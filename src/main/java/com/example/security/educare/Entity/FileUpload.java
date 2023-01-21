package com.example.security.educare.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pq")


public class FileUpload {
        @Id
        @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
        @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
        private Integer id;
        private String image;
        @Transient
        private String imageBase64;


}
