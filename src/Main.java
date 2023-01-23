import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File gameDir = new File("F:\\ProjectJava\\Games");
        File[] dirs = {
                new File(gameDir, "src"),
                new File(gameDir, "res"),
                new File(gameDir, "savegames"),
                new File(gameDir, "temp"),
                new File(gameDir + "\\src\\main"),
                new File(gameDir + "\\src\\test"),
                new File(gameDir + "\\res\\drawables"),
                new File(gameDir + "\\res\\vectors"),
                new File(gameDir + "\\res\\icons"),
        };

        File[] files = {
                new File(gameDir + "\\src\\main\\Main.java"),
                new File(gameDir + "\\src\\main\\Utils.java"),
                new File(gameDir + "\\temp\\temp.txt")
        };


        StringBuilder logger = new StringBuilder();
        //Проверить есть ли корневая директория
        if(!gameDir.exists()){
            logger.append("Папки ").append(gameDir.getName()).append(" не существует!")
                    .append("\nСоздание папки... ")
                    .append(createDir(gameDir));
        }

        //Создание папок и логирование
        for(File dir: dirs){
            logger.append(createDir(dir));
        }

        try {
            //Создание файлов и логирование
            for(File file : files){
                logger.append(createFile(file));
            }

            //Запись лога в файл
            FileWriter fileWriter = new FileWriter(gameDir + "\\temp\\temp.txt");
            fileWriter.append(logger);
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static String createDir(File dir){
        return (dir.mkdirs() ? "Директория создана! " + dir : "Директория не создана!") + "\n";
    }

    public static String createFile(File file) throws IOException {
        return (file.createNewFile() ? "Файл создан! " + file : "Файл создан!") + "\n";
    }
}