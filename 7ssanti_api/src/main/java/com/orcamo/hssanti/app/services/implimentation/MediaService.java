package com.orcamo.hssanti.app.services.implimentation;

import com.orcamo.hssanti.app.dtos.request.MediaReq;
import com.orcamo.hssanti.app.dtos.response.HairSalonResp;
import com.orcamo.hssanti.app.dtos.response.MediaResp;
import com.orcamo.hssanti.app.entities.Article;
import com.orcamo.hssanti.app.entities.HairSalon;
import com.orcamo.hssanti.app.entities.Media;
import com.orcamo.hssanti.app.repositories.ArticleRepository;
import com.orcamo.hssanti.app.repositories.MediaRepository;
import com.orcamo.hssanti.app.services.interfaces.MediaServiceInterface;
import com.orcamo.hssanti.security.User.User;
import com.orcamo.hssanti.security.User.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MediaService implements MediaServiceInterface {
    private final MediaRepository mediaRepository;
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    @Override
    public MediaResp create(MediaReq mediaReq) {
        Optional<Article> article = articleRepository.findById(mediaReq.getArticle_id());
        return article.map(a -> {
            Media media = modelMapper.map(mediaReq, Media.class);
            media.setArticle(a);
            return modelMapper.map(mediaRepository.save(media), MediaResp.class);
        }).orElse(null);
    }

    @Override
    public MediaResp update(MediaReq mediaReq, Integer id) {
        Optional<Media> mediaOptional = mediaRepository.findById(id);
        return mediaOptional.map(media -> {
            Optional<Article> article = articleRepository.findById(mediaReq.getArticle_id());
            return article.map(a -> {
                Media media1 = modelMapper.map(mediaReq, Media.class);
                media1.setArticle(a);
                media1.setId(media.getId());
                return modelMapper.map(mediaRepository.save(media), MediaResp.class);
            }).orElse(null);
        }).orElse(null);
    }

    @Override
    public Integer delete(Integer integer) {
        return null;
    }

    @Override
    public List<MediaResp> getAll() {
        return null;
    }

    @Override
    public MediaResp getOne(Integer integer) {
        return null;
    }

    @Override
    public List<MediaResp> saveAll(List<MediaReq> mediaReqs) {
        List<Media> medias = mediaReqs.stream().map(mediaReq-> {
            Optional<Article> article = articleRepository.findById(mediaReq.getArticle_id());
            return article.map(a->{
               Media media = modelMapper.map(mediaReq, Media.class);
               media.setArticle(a);
               return media;
            }).orElse(null);
        }).toList();
            return mediaRepository.saveAll(medias).stream().map(m ->modelMapper.map(m, MediaResp.class)).collect(Collectors.toList());
    }
}
