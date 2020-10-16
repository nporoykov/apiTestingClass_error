
package dto;

import lombok.*;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.schema.JsonSerializableSchema;

@Data
@Builder
@AllArgsConstructor
@JsonSerialize
public class User {

    private String email;
    private String firstName;
    private long id;
    private String lastName;
    private String password;
    private String phone;
    private long userStatus;
    private String username;

}
