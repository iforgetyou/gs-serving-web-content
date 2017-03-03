package com.zy17.bean;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: cat
 * Date: 14-7-19
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */

@Data
public class InstImage {
  // 图片id
  private String id;
  //  发布者id
  //  private String ownerId;
  //  图片url
  private String image_url;
  //  视频url
  private String video_url;

  private String blob_url;

}
