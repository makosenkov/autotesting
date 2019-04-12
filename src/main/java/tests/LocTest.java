package tests;

public class LocTest extends TestBase {

    private static final String LOGIN = "$x(\".//input[@id='field_email']\")";
    private static final String PASSWORD = "$x(\".//input[@id='field_password']\")";
    private static final String SUBMIT = "$x(\"//form//div[@class='form-actions']//input[@type='submit']\")";

    private static final String FRIENDS = "$x(\"//*[@data-l='t,userFriend']\")";
    private static final String FRIEND_CARD = "$x(\"//*[@class='user-grid-card_img']\")";
    private static final String FRIEND_NAME = "$x(\"//div//*[@class='n-t bold']\")";
    private static final String FRIEND_BUTTON = "$x(\"//*[@data-l='t,sendMessage' and " +
        "@class='button-pro __sec __small __ic __send-msg mt-x __wide']\")";

    private static final String ACTIVE_CHAT = "$x(\"//*[@class='chats_i h-mod __active']\")";
    private static final String CHAT_NAME = "$x(\"//*[@data-l='t,menu_opponent_name']\")";
    private static final String SEND_BUTTON = "$x(\"//*[@class='button-pro comments_add-controls_save']\")";



}
