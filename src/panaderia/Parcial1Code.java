package parcial1remastserizado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Parcial1Code extends JFrame {

    Manejador m = new Manejador();
    Manejador2 mc = new Manejador2();
    Manejador3 mn = new Manejador3();
    //Constructor
    Container contenedor;

    public Parcial1Code() {
        setTitle("Panaderia"); //Titulo
        setSize(900, 600);//Tamaño
        setLocationRelativeTo(null);//Ubica el centro de la pantalla
        iniciarPanel();//Llamo el metodo panel
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Pemrite que cierre la ventana
    }

    //VariablesGlobales
    private JButton añadir, salir, limpiar,generarPrecio;
    private JComboBox box, boxInventario;
    private JTextField texto;
    private JTextArea area;
    private JLabel etiqueta, etiqueta2;
    private JPanel panel, panel2, panel3;
    private int cantidad = 0;
    private int cantidadx = 5;
    private int precio = 0;
    private int precioFinal = 0;

    //Array de productos para el ComboBox//
    public String[] Productos(String estado) {
        String[] productosx = new String[3];

        if (estado.equals("FRIA")) {
            productosx[0] = "Pony Malta";
            productosx[1] = "Jugo de Mango";
            productosx[2] = "Milo";
        } else {
            if (estado.equals("CALIENTE")) {
                productosx[0] = "Cafe";
                productosx[1] = "Chocolate";
                productosx[2] = "Tinto";
            } else {
                if (estado.equals("ENERGIZANTE")) {
                    productosx[0] = "Gato Rade";
                    productosx[1] = "Vive 100";
                    productosx[2] = "Monster";
                } else {
                    if (estado.equals("SALADOS")) {
                        productosx[0] = "Empanada";
                        productosx[1] = "Chorizo";
                        productosx[2] = "Papa Aborrajada";
                    } else {
                        if (estado.equals("DULCES")) {
                            productosx[0] = "Pastel de Fresa";
                            productosx[1] = "Rosquillas";
                            productosx[2] = "Pan Agridulce";
                        }
                    }
                }
            }
        }

        return productosx;
    }
    //////////////////////////////////////////////

    //Iniciar Componentes
    public void iniciarPanel() {
        paneles();
        Botones();
        TextField();
        TextArea();
        etiquetas();
        ComboBox();

    }

    //Metodo de Paneles
    private void paneles() {
        panel = new JPanel(); //Panel creado
        panel.setLayout(null);
        this.getContentPane().add(panel);//Agrego el panel a la ventana
        panel.setBackground(Color.WHITE);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.black);
        panel2.setBounds(0, 0, 250, 600);
        panel.add(panel2);
    }

    //Metodo de etiquetas
    private void etiquetas() {
        etiqueta = new JLabel("ESTADO DE CUENTA");//Estado
        etiqueta.setBounds(490, -20, 300, 300);//Establezco el tamaño y ubicacion del texto
        etiqueta.setForeground(Color.BLACK);//Establezco color de letra

        etiqueta.setFont(new Font("arial", Font.BOLD, 15));
        panel.add(etiqueta);
        
        ////
        
        etiqueta2 = new JLabel("PANADERIA");
        etiqueta2.setBounds(50, -100, 300, 300);
        etiqueta2.setFont(new Font("arial", Font.BOLD, 15));
        etiqueta2.setForeground(Color.red);
        panel2.add(etiqueta2);

    }

    private void Botones() {
        añadir = new JButton("Añadir");//Nombre
        añadir.addActionListener(m);
        añadir.addMouseListener(mc);
        añadir.setBounds(50, 350, 150, 30);//Ubicacion  

        añadir.setEnabled(false);//iteracion del boton
        panel2.add(añadir);//Añado Boton
        //////////

        limpiar = new JButton("Limpiar");
        limpiar.addActionListener(m);
        limpiar.setBounds(50, 400, 150, 30);
        panel2.add(limpiar);

        salir = new JButton("Salir");
        salir.addActionListener(m);
        salir.setBounds(50, 500, 150, 30);
        panel2.add(salir);

        generarPrecio = new JButton("Generar Factura");
        generarPrecio.addActionListener(m);
        generarPrecio.setBounds(50, 450, 150, 30);
        panel2.add(generarPrecio);
        
    }

    private void TextField() {
        texto = new JTextField();
        texto.setBounds(50, 300, 150, 20);
        texto.setText("Cantidad...");
        panel2.add(texto);

    }

    private void TextArea() {
        area = new JTextArea("");
        area.setBackground(Color.BLACK);
        area.setForeground(Color.YELLOW);
        area.setBounds(380, 150, 400, 250);
        panel.add(area);
    }

    private void ComboBox() {

        //ComboBox Menu
        String[] menu = {"MENU", "FRIA", "CALIENTE", "ENERGIZANTE", "DULCES", "SALADOS"};
        box = new JComboBox(menu);
        box.addItemListener(mn);
        box.setBounds(50, 100, 150, 20);
        panel2.add(box);

        //ComboBox Inventario
        boxInventario = new JComboBox();
        boxInventario.setBounds(50, 200, 150, 20);
        box.addItemListener(mn);
        panel2.add(boxInventario);
    }

    //Clase Manejador
    public class Manejador implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == salir) {

                System.exit(0);
            }

            if (e.getSource() == limpiar) {
                area.setText(" ");
            }
            
            if(e.getSource() == generarPrecio){
                area.append("-------------►✪🅕🅐🅒🅣🅤🅡🅐✪◄-------------"+"\n"+
                        "ᴘʀᴇᴄɪᴏ ᴛᴏᴛᴀʟ: "+precioFinal);
            }

            if (e.getSource() == añadir) {

                cantidad = Integer.parseInt(texto.getText());
                if (boxInventario.getSelectedItem().equals("Pony Malta")) {
                    precio = cantidad * 1500;
                    precioFinal += precio;
                    if (cantidad <= 5) {
                        area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                + " " + "Cantidad: " + cantidad + "\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                    }

                } else {
                    if (boxInventario.getSelectedItem().equals("Jugo de Mango")) {
                        precio = cantidad * 2000;
                        precioFinal += precio;
                        if (cantidad <= 5) {
                            area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                    + " " + "Cantidad: " + cantidad + "\n");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                        }

                    } else {
                        if (boxInventario.getSelectedItem().equals("Milo")) {
                            precio = cantidad * 2000;
                            precioFinal += precio;
                            if (cantidad <= 5) {
                                area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                        + " " + "Cantidad: " + cantidad + "\n");
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                            }

                        } else {
                            if (boxInventario.getSelectedItem().equals("Cafe")) {
                                precio = cantidad * 1500;
                                precioFinal += precio;
                                if (cantidad <= 5) {
                                    area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                            + " " + "Cantidad: " + cantidad + "\n");
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                }

                            } else {
                                if (boxInventario.getSelectedItem().equals("Chocolate")) {
                                    precio = cantidad * 2000;
                                    precioFinal += precio;
                                    if (cantidad <= 5) {
                                        area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                + " " + "Cantidad: " + cantidad + "\n");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                    }

                                } else {
                                    if (boxInventario.getSelectedItem().equals("Tinto")) {
                                        precio = cantidad * 1500;
                                        precioFinal += precio;
                                        if (cantidad <= 5) {
                                            area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                    + " " + "Cantidad: " + cantidad + "\n");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                        }

                                    } else {
                                        if (boxInventario.getSelectedItem().equals("Gato Rade")) {
                                            precio = cantidad * 2200;
                                            precioFinal += precio;
                                            if (cantidad <= 5) {
                                                area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                        + " " + "Cantidad: " + cantidad + "\n");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                            }

                                        } else {
                                            if (boxInventario.getSelectedItem().equals("Vive 100")) {
                                                precio = cantidad * 1300;
                                                precioFinal += precio;
                                                if (cantidad <= 5) {
                                                    area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                            + " " + "Cantidad: " + cantidad + "\n");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                                }

                                            } else {
                                                if (boxInventario.getSelectedItem().equals("Monster")) {
                                                    precio = cantidad * 1300;
                                                    precioFinal += precio;
                                                    if (cantidad <= 5) {
                                                        area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                                + " " + "Cantidad: " + cantidad + "\n");
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                                    }
                                                } else {
                                                    if (boxInventario.getSelectedItem().equals("Empanada")) {
                                                        precio = cantidad * 1200;
                                                        precioFinal += precio;
                                                        if (cantidad <= 5) {
                                                            area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                                    + " " + "Cantidad: " + cantidad + "\n");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                                        }
                                                    } else {
                                                        if (boxInventario.getSelectedItem().equals("Chorizo")) {
                                                            precio = cantidad * 1300;
                                                            precioFinal += precio;
                                                            if (cantidad <= 5) {
                                                                area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                                        + " " + "Cantidad: " + cantidad + "\n");
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                                            }
                                                        } else {
                                                            if (boxInventario.getSelectedItem().equals("Papa Aborrajada")) {
                                                                precio = cantidad * 2500;
                                                                precioFinal += precio;
                                                                if (cantidad <= 5) {
                                                                    area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                                            + " " + "Cantidad: " + cantidad + "\n");
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                                                }
                                                            } else {
                                                                if (boxInventario.getSelectedItem().equals("Pastel de Fresa")) {
                                                                    precio = cantidad * 25000;
                                                                    precioFinal += precio;
                                                                    if (cantidad <= 5) {
                                                                        area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                                                + " " + "Cantidad: " + cantidad + "\n");
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                                                    }
                                                                } else {
                                                                    if (boxInventario.getSelectedItem().equals("Rosquillas")) {
                                                                        precio = cantidad * 3500;
                                                                        precioFinal += precio;
                                                                        if (cantidad <= 5) {
                                                                            area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                                                    + " " + "Cantidad: " + cantidad + "\n");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                                                        }
                                                                    } else {
                                                                        if (boxInventario.getSelectedItem().equals("Pan Agridulce")) {
                                                                            precio = cantidad * 500;
                                                                            precioFinal += precio;
                                                                            if (cantidad <= 5) {
                                                                                area.append("Producto: " + boxInventario.getSelectedItem() + " " + "Precio: " + precio
                                                                                        + " " + "Cantidad: " + cantidad + "\n");
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(null, "No se pueden agregar mas de 5 productos por compra!");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }

                    }
                }
            }
        }
    }

    public class Manejador2 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }

    public class Manejador3 implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (box.getSelectedIndex() > 0) {
                    boxInventario.setModel(new DefaultComboBoxModel(Productos(box.getSelectedItem().toString())));
                }
                if (box.getSelectedIndex() > 0) {
                    añadir.setEnabled(true);
                }
            }

        }

    }
}
