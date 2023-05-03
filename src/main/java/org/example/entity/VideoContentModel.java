package org.example.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "video")
@ToString()
@NoArgsConstructor
@AllArgsConstructor
public class VideoContentModel {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "title")
        private String title;

        @Column(name = "year")
        private Long year;

        @Column(name = "genre")
        private String genre;
}
