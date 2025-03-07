/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.Color.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var textField: JTextField
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(570, 440)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        greetingLabel = JLabel("Click a button")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 50, 500, 100)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        textField = JTextField("Name...")
        textField.horizontalAlignment = SwingConstants.CENTER
        textField.addKeyListener(this)
        textField.bounds = Rectangle(50, 150, 450, 100)
        textField.font = defaultFont
        add(textField)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(50,300,200,100)
        helloButton.foreground = Color.white
        helloButton.background = Color(0,33,66)
        helloButton.addActionListener(this)     // Handle any clicks
        helloButton.font = defaultFont
        add(helloButton)

        goodbyeButton = JButton("Goodbye!")
        goodbyeButton.bounds = Rectangle(300,300,200,100)
        goodbyeButton.foreground = Color.white
        goodbyeButton.background = Color(0,33,66)
        goodbyeButton.addActionListener(this)     // Handle any clicks
        goodbyeButton.font = defaultFont
        add(goodbyeButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

            textField -> {
                println("pop")
            }

            helloButton -> {
                val name = textField.text
                if(name == "harry") {
                    textField.text = "access granted"
                    greetingLabel.foreground = Color.green
                    greetingLabel.text = "welcome back harry!"
                }
                else if (name == "") {
                    greetingLabel.text = "enter a name"
                    greetingLabel.foreground = Color.orange
                }
                else {
                    textField.text = "access denied"
                    greetingLabel.foreground = Color.red
                    greetingLabel.text = "user '${name}' not found!"
                }
            }

            goodbyeButton -> {
                val name = textField.text
                if(name=="harry") {
                    greetingLabel.text = "Goodbye, harry!!"
                    greetingLabel.foreground = Color.blue
                }
                else if (name=="" || name=="Name..."){
                    greetingLabel.text = "Goodbye, stranger."
                    greetingLabel.foreground = Color.yellow
                }
                else {
                    greetingLabel.text = "Goodbye, ${name}."
                    greetingLabel.foreground = Color.yellow
                }
            }
        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("key typed: ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("key pressed: ${e?.keyCode}")

        if (e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z) {
            println("Letter key!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        }
        else {
            e?.consume()
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        println("key released: ${e?.keyCode}")
    }
}

