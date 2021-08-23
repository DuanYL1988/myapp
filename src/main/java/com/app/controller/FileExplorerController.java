package com.app.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dto.AjaxResponseDto;
import com.app.dto.LocalFile;
import com.app.form.BaseForm;
import com.app.util.CommonUtils;
import com.app.util.JsonUtil;

@Controller
@RequestMapping(value = "/fileManagement")
public class FileExplorerController {

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    CommonUtils commonUtil;

    @RequestMapping(value = "menu")
    public String goIndex(Model model, HttpServletRequest request) {

        return "fileExplorer/menu";
    }

    @RequestMapping(value = "gallery")
    public String goGallery(Model model, HttpServletRequest request) {
        /*
         * String path = request.getParameter("path"); path =
         * "D:\\project\\myapp\\src\\main\\webapp\\resources\\images\\feh\\acter";
         *
         * Gallery gallery = new Gallery(); model.addAttribute("jsonDate",
         * gallery.createObject(path)); gallery = null;
         */
        String folder = "/myapp/resources/images";
        String game = request.getParameter("game");
        if ("feh".equals(game)) {
            folder = folder + "/feh/acter/";
        } else {
            folder = folder + "/fgo/servant/";
        }
        String name = request.getParameter("name");
        folder = folder + name;

        model.addAttribute("folder", folder);
        model.addAttribute("type", game);
        model.addAttribute("height", request.getParameter("height"));
        return "fileExplorer/gallery";
    }

    @RequestMapping(value = "getChildren")
    @ResponseBody
    public AjaxResponseDto insertOrUpdate(@RequestBody BaseForm form, Model model) {
        AjaxResponseDto response = getFilenames(form.getSelected());

        return response;
    }

    private AjaxResponseDto getFilenames(String path) {
        AjaxResponseDto response = new AjaxResponseDto();
        File base = new File(path);
        // 文件夹判断
        if (base.isDirectory()) {
            response.setCode("1");
            // 子文件
            List<LocalFile> files = new ArrayList<LocalFile>();
            File[] children = base.listFiles();
            if (null == children) {
                response.setCode("0");
                return response;
            }
            for (File file : children) {
                LocalFile locFile = new LocalFile();
                locFile.setFileName(file.getName());
                locFile.setFilePath(file.getPath());
                locFile.setFullPath(file.getAbsolutePath());
                if (file.isDirectory()) {
                    locFile.setFolder(true);
                } else {
                    locFile.setFolder(false);
                    if (file.getName().split(".").length > 1) {
                        locFile.setFileType(file.getName().split(".")[1]);
                    }
                }
                files.add(locFile);
            }

            response.setData(files);
        } else {
            response.setCode("0");
        }
        return response;
    }
}
