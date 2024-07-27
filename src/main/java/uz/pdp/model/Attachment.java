package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
    private int id;
    private String originalName;
    private String generatedName;
    private String contentType;
    private long size;
}
