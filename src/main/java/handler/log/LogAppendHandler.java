package handler.log;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 日志追加处理
 */
public class LogAppendHandler {

    // 服务器
    private static final List<String> SERVERS = List.of("60");

    private static final String ZUUL_LOG = "zuulLog.";

    private static final String ORDER_LOG = "orderLog.";

    /**
     * 追加zuul日志
     * @throws Exception
     */
    public void appendZuul() {
        FileWriter writer = new FileWriter("zuulLog.log");
        appendLog(writer, ZUUL_LOG);


    }

    /**
     * 追加order日志
     */
    public void appendOrder() {
        FileWriter writer = new FileWriter("orderLog.log");
        appendLog(writer, ORDER_LOG);
    }

    private void appendLog(FileWriter writer, String logName) {
        SERVERS.forEach((server) -> {
            String path = "/home/日志/" + server;
            List<String> strings = FileUtil.listFileNames(path);
            strings.forEach((p) -> {
                if (p.contains(logName + DateUtil.format(new Date(), "yyyy-MM-dd"))) {
                    writer.appendLines(new FileReader(path + File.separator + p).readLines());
                }
            });
        });
    }

}
