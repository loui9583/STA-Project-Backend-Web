package dat3.project.testimonial.service;
import dat3.project.testimonial.dto.TestimonialRequest;
import dat3.project.testimonial.dto.TestimonialResponse;
import dat3.project.testimonial.entity.Testimonial;
import dat3.project.testimonial.repository.TestimonialRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestimonialServiceTest {
    @Mock
    private TestimonialRepository testimonialRepository;

    @InjectMocks
    private TestimonialService testimonialService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void fetchAllTestimonials() {
        Testimonial testimonial1 = new Testimonial();
        testimonial1.setId(1);
        Testimonial testimonial2 = new Testimonial();
        testimonial2.setId(2);

        when(testimonialRepository.findAll()).thenReturn(Arrays.asList(testimonial1, testimonial2));

        List<TestimonialResponse> result = testimonialService.fetchAllTestimonials();

        // Assert
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());
    }

    @Test
    void addTestimonial() {
        TestimonialRequest request = new TestimonialRequest();
        request.setText("Testimonial content");

        Testimonial savedTestimonial = new Testimonial();
        savedTestimonial.setId(1);
        savedTestimonial.setText(request.getText());

        when(testimonialRepository.save(any(Testimonial.class))).thenReturn(savedTestimonial);

        TestimonialResponse result = testimonialService.addTestimonial(request);

        // Assert
        assertEquals(1, result.getId());
        assertEquals("Testimonial content", result.getText());
    }

    @Test
    void deleteTestimonial() {
        int testimonialId = 1;

        when(testimonialRepository.existsById(testimonialId)).thenReturn(true);

        ResponseEntity<Boolean> result = testimonialService.deleteTestimonial(testimonialId);

        // Assert
        assertTrue(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());

        verify(testimonialRepository, times(1)).deleteById(testimonialId);
    }
}
