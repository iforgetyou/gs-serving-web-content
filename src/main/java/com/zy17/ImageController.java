package com.zy17;

import com.zy17.bean.InstImage;
import com.zy17.client.InstClient;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/image")
public class ImageController {

  @Autowired
  InstClient client;

  @RequestMapping("")
  public String image(
      @RequestParam(required = false, defaultValue = "10") int pagesize,
      @RequestParam(required = false, defaultValue = "0") int offset,
      Model model) {
    List<InstImage> imagesResource = client.getImagesResource(pagesize, offset);

    model.addAttribute("images", imagesResource);
    model.addAttribute("offset", offset);
    model.addAttribute("pagesize", pagesize);
    return "image";
  }

  @RequestMapping("/like")
  public void like(@RequestParam(required = false, defaultValue = "0") String id) {
    log.debug("{} like +1", id);
  }

}
