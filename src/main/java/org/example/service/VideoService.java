package org.example.service;

import org.example.videoDTO.VideoContentDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VideoService {


    List<VideoContentDTO>findAll();


    VideoContentDTO update(long id, VideoContentDTO videoContentDTO);

    void delete(long id);

    VideoContentDTO save(VideoContentDTO textsDTO);

    List<VideoContentDTO> findByTitle(String title);
}
