package com.zy17.client;


import com.zy17.bean.InstImage;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * 远程服务
 * 2017/2/11 zy17
 */
@Component
@Slf4j
public class InstClient {
  @Value("${image.service.url}")
  public String baseUrl;

  private RestTemplate restTemplate = new RestTemplate();

  /**
   * 获取图片资源
   * @param
   * @return
   */
  public List<InstImage> getImagesResource(int pagesize, int offset) {
    final String uri = baseUrl + "/images" + "?pagesize={pagesize}&offset={offset}";
    InstImage[] instImages = restTemplate.getForObject(uri, InstImage[].class, pagesize, offset);
    return Arrays.asList(instImages);
  }

}


