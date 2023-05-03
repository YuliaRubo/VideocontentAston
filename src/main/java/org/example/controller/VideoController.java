package org.example.controller;


import org.example.service.VideoService;
import org.example.videoDTO.VideoContentDTO;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class VideoController {

    public final VideoService videoService;
    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping(value = "/video")
    public List<VideoContentDTO> getVideo() {
        return videoService.findAll();
    }

    @DeleteMapping(value = "/video/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        videoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/video/{id}")
    public ResponseEntity<VideoContentDTO> update(@PathVariable Long id, @RequestBody VideoContentDTO contentDTO) {
        return new ResponseEntity<>(videoService.update(id, contentDTO), HttpStatus.OK);
    }
    @PostMapping(value = "/video", consumes = "application/json")
    public ResponseEntity<VideoContentDTO> save(@RequestBody VideoContentDTO videoDTO) {
        return new ResponseEntity<>(videoService.save(videoDTO), HttpStatus.CREATED);
    }
}
