package resources;

/**
 * Constant string values for messages and labels.
 * 
 * @author Joseph R.
 * @since May 1, 2020
 */
public enum Strings {
    WINDOW_TITLE("CryptoGUI -- Cryptic Messages"),
    PROJECT_DESC("Written by Joe R.\nsince April 2020\nEmail at foo@foo.com"),
    
    DEBUG_ABOUT_PROJECT("> READING ABOUT PROJECT"),
    DEBUG_CAESAR_INTERFACE("> CREATING CAESAR CIPHER INTERFACE"),
    DEBUG_CLEAR_TEXTS("> CLEARING TEXT AREAS"),
    DEBUG_DECRYPTING_TEXT("> DECRYPTING CIPHERTEXT"),
    DEBUG_ENCRYPTING_TEXT("> ENCRYPTING PLAINTEXT"),
    DEBUG_EXIT_APP("> EXITING APPLICATION"),
    DEBUG_MENU_INTERFACE("> CREATING MAIN MENU INTERFACE"),
    DEBUG_MOVE_TEXTS("> MOVING TEXTS"),
    DEBUG_SAVE_DATA("> SAVING DATA"),
    DEBUG_SELECT_CAESAR("> SELECTING CAESAR CIPHER"),
    DEBUG_SELECT_VIGENERE("> SELECTING VIGENÉRE CIPHER"),
    DEBUG_SWITCH_CIPHER("> SWITCHING CIPHERS"),
    DEBUG_VIGENERE_INTERFACE("> CREATING VIGENÉRE CIPHER INTERFACE"),
    
    ABOUT_PROJECT_LABEL("About Project"),
    CAESAR_LABEL("Caesar Cipher"),
    CHANGE_CRYPTO_LABEL("Change Cryptographic Technique"),
    CLEAR_LABEL("Clear"),
    CONFIRM_LABEL("Confirm"),
    DECRYPT_LABEL("Decrypt"),
    ENCRYPT_LABEL("Encrypt"),
    EXIT_LABEL("Exit"),
    FILE_LABEL("File"),
    HELP_LABEL("Help"),
    MOVE_LABEL("Move"),
    OPTIONS_LABEL("Options"),
    QUIT_LABEL("Quit"),
    SAVE_LABEL("Save Output File"),
    SELECT_CRYPTO_LABEL("Select Cryptographic Technique"),
    SELECT_LABEL("Select"),
    VIGENERE_LABEL("Vigenère Cipher"),
    
    CAESAR_KEY_PROMPT_MSG("Enter a number between 0 and 25 (inclusive)"),
    CLEAR_HINT_MSG("Clear and reset both text screens."),
    CONFIRMATION_MSG("Are you sure?"),
    DECRYPT_HINT_MSG("Decrypt your coded message to get the original text. Same key for encryption is necessary."),
    DEFAULT_MSG("Please select an option"),
    ENCRYPT_HINT_MSG("Encrypt your original message with a key."),
    EXIT_HINT_MSG("Exit the application."),
    INPUT_TEXT_MSG("Enter text here"),
    INVALID_KEY_MSG("!!! Warning: Invalid key value !!!"),
    MOVE_HINT_MSG("Move the text to decrypt."),
    QUIT_MSG("Quit and Exit?"),
    VIGENERE_PASSWORD_PROMPT_MSG("Enter a password"),
    WIP_MSG("Work in progress.");
    
    private final String msg;
    
    private Strings(String msg) {
        this.msg = msg;
    }
    
    /**
     * Return message.
     * 
     * @return constant message
     */
    public String getMsg() {
        return this.msg;
    }
}
