package volodymyr.groupexpense.common.HATEOAS;

import lombok.AllArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
public class CreatedURI {

    private final String path;

    public URI createdURI(){
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path(path)
                .build()
                .toUri();
    }

}
