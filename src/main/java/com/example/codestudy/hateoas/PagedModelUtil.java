package com.example.codestudy.hateoas;

import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.function.Function;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * https://cla9.tistory.com/
 *
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-30
 */
public class PagedModelUtil {
    public static <T> PagedModel<EntityModel<T>> getEntityModels(PagedResourcesAssembler<T> assembler,
                                                                 Page<T> page,
                                                                 Class<?> clazz,
                                                                 Function<T, ?> selfLinkFunc ){
        WebMvcLinkBuilder webMvcLinkBuilder = linkTo(clazz);
        return assembler.toModel(page, model -> LinkResource.of(webMvcLinkBuilder, model, selfLinkFunc::apply));
    }

    public static <T> PagedModel<EntityModel<T>> getEntityModels(PagedResourcesAssembler<T> assembler,
                                                                 Page<T> page,
                                                                 WebMvcLinkBuilder builder,
                                                                 Function<T, ?> selfLinkFunc ){
        return assembler.toModel(page, model -> LinkResource.of(builder, model, selfLinkFunc::apply));
    }
}

/*
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;
    private final PagedResourcesAssembler<CustomerDTO> assembler;

    @GetMapping("/customers")
    public ResponseEntity<PagedModel<EntityModel<CustomerDTO>>> getCustomer(PageableDTO pageableDTO){
        Page<CustomerDTO> customers = service.getCustomer(pageableDTO);

        PagedModel<EntityModel<CustomerDTO>> entityModels = PagedModelUtil.getEntityModels(assembler, customers,
                linkTo(methodOn(this.getClass()).getCustomer(null)),
                CustomerDTO::getCustomerId);
        return ResponseEntity.ok(entityModels);
    }
}
 */
