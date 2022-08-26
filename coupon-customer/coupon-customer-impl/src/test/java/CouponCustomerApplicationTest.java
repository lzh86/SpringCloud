import com.lzh.CouponCustomerApplication;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes= CouponCustomerApplication.class)
public class CouponCustomerApplicationTest {
    @Resource
    private RedissonClient redissonClient;

    @Test
    void testRedisson() {
        RSet<String> hello = redissonClient.getSet("hello");
        System.out.println(hello);
    }
}
