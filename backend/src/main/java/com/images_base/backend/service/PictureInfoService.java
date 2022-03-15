package com.images_base.backend.service;

import com.images_base.backend.modal.entity.PictureInfoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
public interface PictureInfoService {

    /**
     * 检查散列ID是否重复
     *
     * @param pictureId
     * @return
     */
    Integer checkDuplication(String pictureId);

    /**
     * 图片全列表查询
     *
     * @return
     */
    List<PictureInfoEntity> getPictureList();

    /**
     * 创建图片信息
     *
     * @param file
     * @param pictureId
     * @return
     */
    boolean createPictureInfo(MultipartFile file, String pictureId, String filename, String description);

    /**
     * 直接删除单个图片
     *
     * @param pictureId - String
     * @return
     */
    boolean removeByPictureId(String pictureId);
}
