package org.example.videoDTO;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString()
@NoArgsConstructor
@AllArgsConstructor
public class VideoContentDTO {

    private Long id;
    private String title;
    private Long year;
    private String genre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoContentDTO)) return false;
        VideoContentDTO that = (VideoContentDTO) o;
        return getId() == that.getId() && getTitle().equals(that.getTitle()) && getYear().equals(that.getYear()) && getGenre().equals(that.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getYear(), getGenre());
    }
}
