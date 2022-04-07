package com.images_base.backend;

import com.images_base.backend.modal.entity.PictureInfoEntity;
import com.images_base.backend.service.PictureInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/4/7
 */
@SpringBootTest
class PictureServiceTests {

    @Autowired
    PictureInfoService pictureInfoService;

    @Test
    void testPictureList() {
        List<PictureInfoEntity> pictureList = pictureInfoService.getPictureList();
        pictureList.forEach(entity -> System.out.println(entity.getPictureId()));
    }
}
