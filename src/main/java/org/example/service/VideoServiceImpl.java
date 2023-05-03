package org.example.service;

import org.example.entity.VideoContentModel;
import org.example.exception.NotFoundException;
import org.example.repository.VideoRepository;
import org.example.videoDTO.VideoContentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository, ModelMapper modelMapper) {
        this.videoRepository = videoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<VideoContentDTO> findAll() {
        List<VideoContentModel> videoContentModels = videoRepository.findAll();
        if (videoContentModels.isEmpty()) {
            throw new NotFoundException("Нет записей");
        }

        return videoContentModels.stream()
                .map(v -> modelMapper.map(videoContentModels, VideoContentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VideoContentDTO update(long id, VideoContentDTO videoContentDTO) {
        VideoContentModel videoContentModel = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Нет элементов с таким id: " + id));
        videoContentModel.setTitle(videoContentDTO.getTitle());
        videoContentModel.setYear(videoContentDTO.getYear());
        videoContentModel.setGenre(videoContentDTO.getGenre());
        return modelMapper.map(videoRepository.save(videoContentModel), VideoContentDTO.class);
    }

    @Override
    public void delete(long id) {
        VideoContentModel videoContentModel = videoRepository.findById(id).orElseThrow(() -> new NotFoundException("Нет записей с таким" + id));
        videoRepository.delete(videoContentModel);
    }

    @Override
    public VideoContentDTO save(VideoContentDTO videoContentDTO) {

        VideoContentModel video = modelMapper.map(videoContentDTO, VideoContentModel.class);
        VideoContentModel updatedVideo = videoRepository.save(video);
        return modelMapper.map(updatedVideo, VideoContentDTO.class);
    }

    @Override
    public List<VideoContentDTO> findByTitle(String title) {
        List<VideoContentModel> listModel = videoRepository.findAll();
        if (listModel.isEmpty()) {
            throw new NotFoundException("Элементы не найдены");
        }
        return listModel.stream().map(v->modelMapper.map(v, VideoContentDTO.class)).collect(Collectors.toList());
    }
}
