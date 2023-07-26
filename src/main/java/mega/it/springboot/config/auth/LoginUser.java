package mega.it.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //적용 범위가 파라미터이다 매개변수 (파라미터에만 사용 가능)
@Retention(RetentionPolicy.RUNTIME) //런타임 때 실행된다
public @interface LoginUser {

}
