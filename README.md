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

#依赖注入
1、@Autowired会根据属性的类型去IOC容器中找到对应的Bean注入（所以属性必须有@Bean的注解，否则会报错)\
2、@Autowired注入的属性有多个类时，会根据类型找到bean，再根据属性名进行匹配，匹配上就使用该Bean，匹配不上就会报错，所以一个实现类的时候可以随便起名字，多个实现类的话名字一定要和实现类一样（如果没有另外定义名字的话）\
同一个接口的实现类类名不要一样，否则会找不到对应的bean报错，如果一定要同样的类名，可以给它起名，默认会先加载没有别名的bean\
3、@Autowired除了标注属性，标注对应的setter方法也能达到同样的效果\
4、@Primary表示有多个同样类型的Bean时，优先使用有这个注解的Bean\
5、@Autowired可以配合@Qualifier("beanName")一起使用，spring IOC会以类型和名称去寻找对应的bean\
6、也可以在使用类（BusinessPerson)的带参构造函数中使用注解，测试的时候没有生效，而且不利于代码阅读，不推荐这种方式\


