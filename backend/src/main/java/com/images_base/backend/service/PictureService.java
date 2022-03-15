package com.images_base.backend.service;

import com.images_base.backend.modal.entity.PictureEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
public interface PictureService {

    /**
     * 上传图片
     *
     * @param filename    - String
     * @param description - String
     * @param file        - MultipartFile
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws SQLException
     */
    void uploadPicture(String filename, String description, MultipartFile file) throws IOException, NoSuchAlgorithmException, SQLException;

    /**
     * 图片全列表查询
     *
     * @return
     */
    List<PictureEntity> getPictureList();

    /**
     * 查看图片
     *
     * @param pictureId
     * @return
     */
    PictureEntity getOneByPictureId(String pictureId);

    /**
     * 直接删除单个图片
     *
     * @param pictureId - String
     * @return
     */
    boolean removeByPictureId(String pictureId);
}
