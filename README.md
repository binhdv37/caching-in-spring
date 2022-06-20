# caching in spring
- This is a spring boot base app with jwt authentication. Test caching in spring.

# Init db data:
- Generate db schema by code :
  spring.jpa.hibernate.ddl-auto = create
- Insert init data:
  Run sql file : resources/sql/initDb.sql
  
# About project structure:
- This project follow some common design pattern like MVC, DAO, DTO, ...

# Some note on spring cache
- @Cacheable, @CacheEvict, @CachePut, @Caching, @CacheConfig
- @Cacheable, @CachePut use method param to be key of caching map.

- Caching with condition parameter: ( access param ?)
   + Use SpEL 
   + Cache only when expression is valid
   + E.g.
   @CachePut(value="addresses", condition="#customer.name=='Tom'")
   public String getAddress(Customer customer) {...}
   
- Caching with unless parameter: ( access function output ?)
   + Use SpEL
   + Based on the output of the method rather than the input
   + E.g.
   @CachePut(value="addresses", unless="#result.length()<64")
   public String getAddress(Customer customer) {...}

    
