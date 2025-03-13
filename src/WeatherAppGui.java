import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class WeatherAppGui extends JFrame {

    public WeatherAppGui() {

        super("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        addGuiComponents();

    }

    private void addGuiComponents() {

        JTextField searchtTextField = new JTextField();
        searchtTextField.setBounds(15, 15, 351, 45);
        searchtTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(searchtTextField);

        JButton searchButton = new JButton(loadImage("assets/search.png"));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        add(searchButton);

        JLabel waetherConditionImage = new JLabel(loadImage("assets/cloudy.png"));
        waetherConditionImage.setBounds(0, 125, 450, 217);
        add(waetherConditionImage);

        JLabel temperatureText = new JLabel("25°C");
        temperatureText.setBounds(0, 350, 450, 50);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));

        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0, 405, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

        JLabel humidityImage = new JLabel(loadImage("assets/humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(100, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        JLabel windSpeedImage = new JLabel(loadImage("assets/windspeed.png"));
        windSpeedImage.setBounds(220, 500, 77, 66);
        add(windSpeedImage);

    }

    private ImageIcon loadImage(String resourcePath) {

        URL imgURL = getClass().getClassLoader().getResource(resourcePath);
        if (imgURL != null) {
            try {
                BufferedImage image = ImageIO.read(imgURL);
                return new ImageIcon(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Could not find resource: " + resourcePath);
        }
        return null;

    }

}
