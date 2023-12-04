package dat3.project.testimonial.dto;

import dat3.project.testimonial.entity.Testimonial;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestimonialRequest {
    private String text;
    private String submissionName;
    private String image;

    public static Testimonial testimonialFromRequest(TestimonialRequest testimonialRequest){
        return Testimonial.builder().text(testimonialRequest.getText())
                .submissionName(testimonialRequest.getSubmissionName())
                .image(testimonialRequest.getImage())
                .build();
    }
}
