# demo
1、@Configuration代表这是一个Java配置文件，Spring的容器将根据它来生成Bean\
2、@Bean代表将方法返回的POJO装配到IoC容器中，而其属性name定义这个Bean的名称，如果偶没有配置，则将方法名保存到Spring IOC容器中\
3、可以使用名称和对象来获取Bean，使用UserPO.class方法来获取POJO时，需要确定AppConfig中只有一个接口是返回UserPO对象，否则会报错：\
`Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.example.demo.po.UserPO' available: expected single matching bean but found 2: user,user2`\
4、@Component标明哪个类被扫描进Spring IOC容器，@ComponentScan则是标明以何种策略去扫描装配Bean\
5、@Component标明这个类将被Spring IOC扫描，而@Component("")中的属性将作为Bean的名称，如果不写将以类名的第一个字母小写作为名字，@Value指属性对应的值\
6、@ComponentScan只扫描AppConfig所在的当前包和子包，当@ComponentScan和@Bean同时存在时,会获取到@Bean的值\
7、@ComponentScan配置项：basePackages定义扫描包名，basePackageClasses定义扫描的类名，与前面的属性形成并集，includeFilters满足条件的Bean才扫描，excludeFilters排除过滤器条件的Bean