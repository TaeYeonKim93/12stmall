package stmall.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmall.domain.*;

@Component
public class DelieveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Delievery>> {

    @Override
    public EntityModel<Delievery> process(EntityModel<Delievery> model) {
        return model;
    }
}
