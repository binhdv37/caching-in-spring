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
- @Cacheable, @CachePut by default use method param to be key of caching map, can change this by "key" parameter.

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

    
- Explain some important anotation:
   + @Cacheable: 
      - Mỗi lần call, hàm này check trong cache xem có data không. 
        1. Có: return data từ cache, không chạy vào thân hàm.
        2. Không: Chạy vào nội dung hàm, return kq như thông thường. Ngoài ra, kết quả còn được lưu vào cache.
        
   + @CacheEvict:
      - Remove key khỏi cache
      
   + @CachePut:
      - Mỗi lần call, hàm này luôn chạy vào thân hàm ( Dù đã có cache của key này hay chưa )
      - Kết quả trả về được update vào cache
      
   + @Caching:
      - Dùng trong th muốn kết hợp muốn dùng "multiple annotations of the same type"
      - VD: @Caching(evict = { 
              @CacheEvict("addresses"), 
              @CacheEvict(value="directory", key="#customer.name") })
              
   + @CacheConfig
      - Thường dùng để config 1 số thông số caching dùng chung trong 1 class, đặt ở class level, không cần cần cấu hình riêng
        lẻ ở method level.
      - VD: Config cache name (Ở class level):
        @CacheConfig(cacheNames = "caching-in-spring-app:role")
        public class RoleServiceImpl implements RoleService {...}
        
        
- Remaining issues:
   + RoleServiceImpl: Không clear được cache khi call clearCacheById(id) trong save() và deleteById(). 