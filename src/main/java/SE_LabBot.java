import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import java.io.File;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class SE_LabBot extends TelegramLongPollingBot {
    int counter = 0;
    int variant = 0;

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        SE_LabBot bot = new SE_LabBot();
        botsApi.registerBot(bot);
    }

    @Override
    public void onUpdateReceived(Update update) {
        String[] var;
        double a;
        double b;
        double c;
        double n;
        double x;
        double z;
        double y;
        double f;
        double d;

        if (update.hasMessage() && update.getMessage().hasText()){
            Message message = update.getMessage();
            var user = message.getFrom();// чисто для проверки
            System.out.println(user.getFirstName() + " wrote " + message.getText()); // чисто для проверки
            System.out.println("counter start c " + counter);
            switch (counter) {
                case 0: {
                    if ("/start".equals(message.getText())) {
                        sendMessage(message.getChatId(), "Привет \uD83D\uDE0E");
                        SendPhoto sendPhoto = new SendPhoto();
                        sendPhoto.setChatId(String.valueOf(message.getChatId()));
                        sendPhoto.setPhoto(new InputFile(new File("C:\\Users\\abram\\IdeaProjects\\tgBot\\var.png")));
                        sendCustomKeyboard(message);
                        try {
                            execute(sendPhoto);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        sendMessage(message.getChatId(), "Ваш вариант " + message.getText());
                        System.out.println("counter" + counter);
                        counter++;
                        System.out.println("counter" + counter);
                        variant = Integer.parseInt(message.getText());
                        System.out.println("variant " + variant);
                    }
                }
                case 1: {
                    switch (variant) {
                        case 1: {
                            sendMessage(message.getChatId(), "Введите значение переменных a b c n x через пробел");
                            counter++;
                            break;
                        }
                        case 2: {
                            sendMessage(message.getChatId(), "Введите значение переменных x y a f через пробел");
                            counter++;
                            break;
                        }
                        case 3: {
                            sendMessage(message.getChatId(), "Введите значение переменных a0 a1 a2 x через пробел");
                            counter++;
                            break;
                        }
                        case 4: {
                            sendMessage(message.getChatId(), "Введите значение переменных a x через пробел");
                            counter++;
                            break;
                        }
                        case 5: {
                            sendMessage(message.getChatId(), "Введите значение переменных a b c d x через пробел");
                            counter++;
                            break;
                        }
                        case 6:
                        case 7: {
                            sendMessage(message.getChatId(), "Введите значение переменной x");
                            counter++;
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    var = message.getText().split(" ");
                    switch (variant) {
                        case 1 -> {
                            if (var.length != 5) {
                                sendMessage(message.getChatId(), "Неправильное количество переменных");
                            } else {
                                a = Double.parseDouble(var[0]);
                                b = Double.parseDouble(var[1]);
                                c = Double.parseDouble(var[2]);
                                n = Double.parseDouble(var[3]);
                                x = Double.parseDouble(var[4]);
                                z = ((5 * Math.pow(a, n * x)) / (b + c)) - (Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3)))));
                                sendMessage(message.getChatId(), String.valueOf(z));
                                counter = 0;
                            }
                        }
                        case 2 -> {
                            if (var.length != 4) {
                                sendMessage(message.getChatId(), "Неправильное количество переменных");
                            } else {
                                x = Double.parseDouble(var[0]);
                                y = Double.parseDouble(var[1]);
                                a = Double.parseDouble(var[2]);
                                f = Double.parseDouble(var[3]);
                                z = ((Math.abs(x - y) / Math.pow((1 + 2 * x), a)) - Math.pow(Math.E, Math.sqrt(1 + f)));
                                sendMessage(message.getChatId(), String.valueOf(z));
                                counter = 0;
                            }
                        }
                        case 3 -> {
                            if (var.length != 4) {
                                sendMessage(message.getChatId(), "Неправильное количество переменных");
                            } else {
                                x = Double.parseDouble(var[2]);
                                a = Double.parseDouble(var[0]);
                                c = Double.parseDouble(var[3]);
                                b = Double.parseDouble(var[1]);
                                z = (Math.sqrt(a + b * x + c * Math.pow((Math.abs(Math.sin(x))), 1 / 3)));
                                sendMessage(message.getChatId(), String.valueOf(z));
                                counter = 0;
                            }
                        }
                        case 4 -> {
                            if (var.length != 2) {
                                sendMessage(message.getChatId(), "Неправильное количество переменных");
                            } else {
                                a = Double.parseDouble(var[0]);
                                x = Double.parseDouble(var[1]);
                                z = Math.log10(Math.pow(a, 7)) + (1 / Math.tan(x * x)) + Math.PI / Math.sqrt(Math.abs(a + x));
                                sendMessage(message.getChatId(), String.valueOf(z));
                                counter = 0;
                            }
                        }
                        case 5 -> {
                            if (var.length != 5) {
                                sendMessage(message.getChatId(), "Неправильное количество переменных");
                            } else {
                                a = Double.parseDouble(var[0]);
                                b = Double.parseDouble(var[1]);
                                c = Double.parseDouble(var[2]);
                                d = Double.parseDouble(var[3]);
                                x = Double.parseDouble(var[4]);
                                z = Math.pow((Math.pow((a + b), 2) / (c + d)) + (Math.pow(Math.E, Math.sqrt(x + 1))), (1 / 5));
                                sendMessage(message.getChatId(), String.valueOf(z));
                                counter = 0;
                            }
                        }
                        case 6 -> {
                            for (String s : var) {
                                System.out.println(s);
                            }
                            if (var.length != 1) {
                                sendMessage(message.getChatId(), "Неправильное количество переменных");
                            } else {
                                x = Double.parseDouble(var[0]);
                                z = Math.pow(Math.E, ((2 * Math.sin(4 * x + Math.cos(x * x) * Math.cos(x * x))) / (3 * x)));
                                sendMessage(message.getChatId(), String.valueOf(z));
                                counter = 0;
                            }
                        }
                        case 7 -> {
                            if (var.length != 1) {
                                sendMessage(message.getChatId(), "Неправильное количество переменных");
                            } else {
                                x = Double.parseDouble(var[0]);
                                z = ((1 / 4) * (((1 + Math.pow(x, 2)) / (1 - x)) + ((1 / 2) * (Math.sin(x) / Math.cos(x)))));
                                sendMessage(message.getChatId(), String.valueOf(z));
                                counter = 0;
                            }
                        }
                    }
                }
            }
        }

    }

    public ReplyKeyboardMarkup createCustomKeyboard(){ // клавиатура
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add("1");
        row1.add("2");
        row1.add("3");
        keyboard.add(row1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add("4");
        row2.add("5");
        row2.add("6");
        keyboard.add(row2);
        KeyboardRow row3 = new KeyboardRow();
        row3.add("7");
        keyboard.add(row3);
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    public void sendCustomKeyboard(Message message) {
        String chatId = String.valueOf(message.getChatId());
        ReplyKeyboardMarkup customKeyboard = createCustomKeyboard();
        SendMessage sndmessage = new SendMessage();
        sndmessage.setChatId(chatId);
        sndmessage.setText("Выберите вариант");
        sndmessage.setReplyMarkup(customKeyboard);
        try {
            execute(sndmessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    @Override
    public String getBotUsername() {
        return "SE_LabBot";
    }

    public String getBotToken() {
        return "5810814610:AAH2zJW3FYeDbWcGO9-FbxM_K6OIWZpqvHo";
    }
}