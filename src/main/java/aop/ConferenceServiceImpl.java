package aop;

import org.springframework.stereotype.Component;

/**
 * @program: algorithm
 * @description:
 * @author: szm
 * @create: 2020-03-04 15:42
 **/
@Component
public class ConferenceServiceImpl implements ConferenceService {
    @Override
    public void conference() {
        System.out.println("开会......");
    }
}
