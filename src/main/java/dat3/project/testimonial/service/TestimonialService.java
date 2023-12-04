package dat3.project.testimonial.service;

import dat3.project.testimonial.dto.TestimonialRequest;
import dat3.project.testimonial.dto.TestimonialResponse;
import dat3.project.testimonial.entity.Testimonial;
import dat3.project.testimonial.repository.TestimonialRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialService {
    TestimonialRepository testimonialRepository;

    public TestimonialService(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    public List<TestimonialResponse> fetchAllTestimonials() {
        List<Testimonial> testimonials = testimonialRepository.findAll();
        return testimonials.stream()
                .map(TestimonialResponse::new)
                .collect(Collectors.toList());
    }
    public TestimonialResponse addTestimonial(TestimonialRequest testimonialRequest){
        Testimonial testimonial = TestimonialRequest.testimonialFromRequest(testimonialRequest);
        testimonial = testimonialRepository.save(testimonial);
        return new TestimonialResponse(testimonial);
    }
    public ResponseEntity<Boolean> deleteTestimonial(int id){
        if(!testimonialRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Testimonial doesn't exist");
        }
        try {
            testimonialRepository.deleteById(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not delete testimonial");
        }
    }
}
