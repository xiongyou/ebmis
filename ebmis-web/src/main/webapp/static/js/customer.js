function getMediaPath(fileType) {
    if(fileType == 1) { // 图片
        return "http://xbzy.cqedu.net:8090/media/pic/"
    } else  { //音视频
        return "http://xbzy.cqedu.net:8090/media/res/"
    }
    return ""
}

/**
 * 通过文件扩展名获取文件类型
 * @param fileType
 * @private
 */
function getFileType(ext) {
    let type = 1
    switch(ext) {
        case '.jpg':
        case ".jpeg":
        case ".bmp":
        case ".png":
            type = 1;
            break;
        case ".doc":
        case ".docx":
        case ".xls":
        case ".xlsx":
        case ".ppt":
        case ".pptx":
            type = 2;
            break;
        case ".pdf":
            type = 3;
            break;
        case ".mp3":
        case ".mp4":
            type = 4;
            break;
        default :
            type = 0;
    }
    return type;
}