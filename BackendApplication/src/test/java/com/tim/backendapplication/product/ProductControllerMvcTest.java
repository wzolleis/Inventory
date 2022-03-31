package com.tim.backendapplication.product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tim.testutils.RestApiLinks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static com.tim.testutils.RandomValues.randomInt;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @BeforeEach
    public void initMocks() {
        Mockito.reset(productService);
    }

    @Test
    public void givenProductExistThenBodyAndStatusIsOk() throws Exception {
        int productId = randomInt();
        when(productService.retrieveProductResponse(eq(productId)))
                .thenReturn(ProductTestData.randomProductDTO(productId));

        MvcResult result = this.mockMvc
                .perform(get(RestApiLinks.productApiLink(productId)))
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        ProductDTO productResponse = new ObjectMapper().readValue(json, ProductDTO.class);
        assertThat(productResponse.getId()).isEqualTo(productId);
    }

    @Test
    public void givenJobExistThenBodyAndStatusIsOk() throws Exception {
        int jobId = randomInt();
        int productId = randomInt();
        ProductDTO randomProduct = ProductTestData.randomProductDTO(productId);
        randomProduct.setJobID(jobId);
        List<ProductDTO> products = Arrays.stream(new ProductDTO[]{randomProduct}).toList();
        when(productService.findProductsByJobID(eq(jobId))).thenReturn(products);

        MvcResult result = this.mockMvc
                .perform(get(RestApiLinks.jobApiLink(jobId)))
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        List<ProductDTO> productResponse = new ObjectMapper().readValue(json, new TypeReference<>() {
        });
        assertThat(productResponse.size()).isEqualTo(1);
        ProductDTO productDTO = productResponse.get(0);
        assertThat(productDTO.getId()).isEqualTo(productId);
        assertThat(productDTO.getJobID()).isEqualTo(jobId);
    }

}
