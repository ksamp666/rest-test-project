package models.rest.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class HelloWorldResponse extends BaseResponse {
    String message;
}
