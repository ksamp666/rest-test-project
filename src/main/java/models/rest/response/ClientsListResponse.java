package models.rest.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientsListResponse extends BaseResponse {
    List<String> clients;
}
