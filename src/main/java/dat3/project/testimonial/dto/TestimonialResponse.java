package dat3.project.testimonial.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.project.testimonial.entity.Testimonial;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestimonialResponse {
    private int id;
    private String text;
    private String image;
    private String submissionName;

    public TestimonialResponse(Testimonial testimonial) {
        this.id = testimonial.getId();
        this.text = testimonial.getText();
        this.image = testimonial.getImage();
        this.submissionName = testimonial.getSubmissionName();
    }
}
