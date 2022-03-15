package com.images_base.backend.service;

import com.images_base.backend.modal.vo.picture.PictureFileVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

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
    @Transactional(rollbackFor = Exception.class)
    void uploadPicture(String filename, String description, MultipartFile file) throws IOException, NoSuchAlgorithmException;

    /**
     * 查看图片
     *
     * @param pictureId
     * @return
     */
    PictureFileVO getOneByPictureId(String pictureId);

    /**
     * 直接删除单个图片
     *
     * @param pictureId - String
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    boolean removeByPictureId(String pictureId);
}
