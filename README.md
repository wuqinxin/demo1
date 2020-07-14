# Bean的装配

1、@Configuration代表这是一个Java配置文件，Spring的容器将根据它来生成Bean\
2、@Bean代表将方法返回的POJO装配到IoC容器中，而其属性name定义这个Bean的名称，如果偶没有配置，则将方法名保存到Spring IOC容器中\
3、可以使用名称和对象来获取Bean，使用UserPO.class方法来获取POJO时，需要确定AppConfig中只有一个接口是返回UserPO对象，否则会报错：\
`Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.example.demo1.po.UserPO' available: expected single matching bean but found 2: user,user2`\
4、@Component标明哪个类被扫描进Spring IOC容器，@ComponentScan则是标明以何种策略去扫描装配Bean\
5、@Component标明这个类将被Spring IOC扫描，而@Component("")中的属性将作为Bean的名称，如果不写将以类名的第一个字母小写作为名字，@Value指属性对应的值\
6、@ComponentScan只扫描AppConfig所在的当前包和子包，当@ComponentScan和@Bean同时存在时,会获取到@Bean的值\
7、@ComponentScan配置项：basePackages定义扫描包名，basePackageClasses定义扫描的类名，与前面的属性形成并集，includeFilters满足条件的Bean也会被扫描，与包扫描属于并集，excludeFilters从结果中排除过滤器条件的Bean\
8、excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = UserPO.class)})\
其中FilterType有两种，FilterType.ASSIGNABLE_TYPE:类扫描，FilterType.ANNOTATION:@注释扫描（此处不能定义为@Component，否则所有的类都无法扫描）\

# 依赖注入

1、@Autowired会根据属性的类型去IOC容器中找到对应的Bean注入（所以属性必须有@Bean的注解，否则会报错)\
2、@Autowired注入的属性有多个类时，会根据类型找到bean，再根据属性名进行匹配，匹配上就使用该Bean，匹配不上就会报错，所以一个实现类的时候可以随便起名字，多个实现类的话名字一定要和实现类一样（如果没有另外定义名字的话）\
同一个接口的实现类类名不要一样，否则会找不到对应的bean报错，如果一定要同样的类名，可以给它起名，默认会先加载没有别名的bean\
3、@Autowired除了标注属性，标注对应的setter方法也能达到同样的效果(setter方法上面要有标注)\
4、@Primary表示有多个同样类型的Bean时，优先使用有这个注解的Bean\
5、@Autowired可以配合@Qualifier("beanName")一起使用，spring IOC会以类型和名称去寻找对应的bean\
6、也可以在使用类（BusinessPerson)的带参构造函数中使用注解，测试的时候没有生效，而且不利于代码阅读，不推荐这种方式\

# 生命周期

Bean的生命周期大致分为：Bean定义、Bean初始化、Bean生存期、Bean销毁\
Bean定义\
1、spring通过我们的配置，如@ComponentScan定义的扫描路径去找到带有@Component的类，这个过程就是一个资源定位\
2、一旦找到了资源，那么它就开始解析，并且将定义的信息保存起来（定义bean）\
3、然后就会把Bean定义发布到Spring IOC容器中。此时的IOC容器也只有Bean的定义，还没有Bean的实例生成\
过程：资源定位（如@ComponentScan所定义的扫描包）>>bean定义（将Bean的定义保存到BeanDefinition的实例中）>>发布bean定义(IOC容器装载Bean定义)>>实例化（创建Bean的实例对象）>>依赖注入（如@Autowired注入的各类资源）\
4、ComponentScan中还有一个配置项：lazyInit（延迟初始化）
，默认不延迟\
5、Bean的完整生命周期：初始化>>>依赖注入>>>setBeanName方法(接口BeanNameAware)>>>setBeanFactory方法(接口BeanFactoryAware)>>>setApplicationContext方法(ApplicationContextAware/需要容器实现Applicationcontext接口才调用)>>>postProcessBeforeInitialization方法(BeanPostProcessor的与初始化方法/针对全部Bean生效)>>>自定义初始化方法(@PostConstruct标注方法/注解)>>>AfterPropertiesSet方法(Initialization方法)>>>生存期>>>自定义销毁方法(@PreDestroy标注方法/注解)>>>destroy方法(DisposableBean)\
6、如果配置了懒加载，只会调用postProcessorBeforeInitialization、postProcessAfterInitialization方法\
7、引用属性文件的方式：1、在属性上引用和setter方法上引用：@Value("${XXX.xxx}")，属性上引用启动的时候似乎不会调用setter方法，在setter方法上引用启动的时候会调用\
2、在类名上添加注解：@ConfigurationProperties("XXX"),类的属性名与配置文件的属性名一致，会在启动的时候调用setter打印\
8、可以定义自己的配置文件，在启动类中加载：@PropertySource(value={"classpath:jdbc.properties"},ignoreResourceNotFound=true),ignore意味着忽略配置文件找不到的问题，默认值为false，开启时没有找到不会报错。自定义配置文件优先级低于application.properties\
9、当某些配置文件的属性不存在时，可以通过配置类添加@Conditional(DatabaseConditional.class)来让IOC容器不装载这个属性，启动不报错。其中的DatabaseConditional为自己定义的类，继承自Condition接口，实现match方法判断\
```java
public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata){
        //取出环境配置
        Environment env = context.getEnvironment();
        //判断属性文件是否存在对应的数据库配置
        return env.containsProperty("database.driverName") && env.containsProperty("database.url")
                && env.containsProperty("database.username") && env.containsProperty("databse.password");
    }
```

# Bean的作用域
singleton：默认值，IOC容器只存在单例。此作用域下修改一个bean另外的bean属性值也会跟着发生变化\
prototype：每当从IOC容器中取出一个Bean，则创建一个新的Bean\
session：Http会话\
application：Web工程生命周期\
request：Web工程单次请求\
globalSession：在一个全局的HTTPSession中，一个Bean定义一个实例。实践中基本不使用\
\
可以用@Profile定义不同的bean，配置不同的数据库，以便在不同的环境中进行切换\
Spring中存在两个参数来修改启动profile的机制，一个是spring.profiles.active，另一个是spring.profile.default\
在这两个属性都没有配置的情况下，spring将不会启动profile机制，也就意味着呗@Profile标注的Bean将不会被spring装配到IOC容器中\
spring是先判定是否存在spring.profiles.active配置后，再去查找spring.profile.default配置，所以spring.profile.active的优先级大于spring.profile.default\
使用@ImportResource可以引入xml文件中的配置：@ImportResource(value = {"classpath:spring-other.xml"})\
springEL可以拥有更为强大的运算规则来装配Bean，比如使用@Value读取属性文件的值\
@Value中#{}代表启用spring表达式，它将具有运算的功能；T(...)表示引入类，如果是Java.lang.*包里面的类，可以不必写全名，如果是其他的包，需要写出全限定名才能引用类.\
比如：@Value("#{T(System).currentTimeMillis()}")代表获取当前系统的时间，其中currentTimeMillis是System的静态方法,同样可以使用@Value("#{bean.method()}")来给它赋其他值,但是调用的方法必须是静态方法，否则会报错\

