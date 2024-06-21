import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TiendaApp extends JFrame {

    private JPanel contentPane;
    private JTextField entryNombreCategoria;
    private JTextField entryNombreProducto;
    private JTextField entryPrecioProducto;
    private JTextField entryNombreCliente;
    private JTextField entryApellidoCliente;
    private JTextField entryCantidadProducto;
    private JComboBox<Categoria> comboCategorias;
    private JComboBox<Producto> comboProductos;
    private JComboBox<Cliente> comboClientes;
    private JComboBox<Cliente> comboClientesTotal;
    private JLabel labelTotalOrden;
    private JLabel labelTotalCompras;

    private Tienda tienda;
    private Orden ordenActual;

    public TiendaApp() {
        tienda = new Tienda();
        setTitle("Aplicación de Tienda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        // Paneles de pestañas
        tabbedPane.addTab("Registrar Categoría", null, crearPanelRegistrarCategoria(), null);
        tabbedPane.addTab("Registrar Producto", null, crearPanelRegistrarProducto(), null);
        tabbedPane.addTab("Registrar Cliente", null, crearPanelRegistrarCliente(), null);
        tabbedPane.addTab("Crear Orden", null, crearPanelCrearOrden(), null);
        tabbedPane.addTab("Calcular Total Compras", null, crearPanelCalcularTotalCompras(), null);

        inicializarInterfaz();
    }

    private JPanel crearPanelRegistrarCategoria() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelNombreCategoria = new JLabel("Nombre Categoría:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelNombreCategoria, gbc);

        entryNombreCategoria = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(entryNombreCategoria, gbc);
        entryNombreCategoria.setColumns(20);

        JButton btnRegistrarCategoria = new JButton("Registrar Categoría");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(btnRegistrarCategoria, gbc);

        btnRegistrarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCategoria();
            }
        });

        return panel;
    }

    private JPanel crearPanelRegistrarProducto() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelNombreProducto = new JLabel("Nombre Producto:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelNombreProducto, gbc);

        entryNombreProducto = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(entryNombreProducto, gbc);
        entryNombreProducto.setColumns(20);

        JLabel labelPrecioProducto = new JLabel("Precio Producto:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelPrecioProducto, gbc);

        entryPrecioProducto = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(entryPrecioProducto, gbc);
        entryPrecioProducto.setColumns(20);

        JLabel labelCategoriaProducto = new JLabel("Categoría:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelCategoriaProducto, gbc);

        comboCategorias = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(comboCategorias, gbc);

        JButton btnRegistrarProducto = new JButton("Registrar Producto");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(btnRegistrarProducto, gbc);

        btnRegistrarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarProducto();
            }
        });

        return panel;
    }

    private JPanel crearPanelRegistrarCliente() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelNombreCliente = new JLabel("Nombre Cliente:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelNombreCliente, gbc);

        entryNombreCliente = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(entryNombreCliente, gbc);
        entryNombreCliente.setColumns(20);

        JLabel labelApellidoCliente = new JLabel("Apellido Cliente:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelApellidoCliente, gbc);

        entryApellidoCliente = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(entryApellidoCliente, gbc);
        entryApellidoCliente.setColumns(20);

        JButton btnRegistrarCliente = new JButton("Registrar Cliente");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(btnRegistrarCliente, gbc);

        btnRegistrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCliente();
            }
        });

        return panel;
    }

    private JPanel crearPanelCrearOrden() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel labelSeleccionarCliente = new JLabel("Seleccionar Cliente:");
        comboClientes = new JComboBox<>();
        comboClientes.setPreferredSize(new Dimension(200, 25));

        JButton btnCrearOrden = new JButton("Crear Orden");

        JLabel labelSeleccionarProducto = new JLabel("Seleccionar Producto:");
        comboProductos = new JComboBox<>();
        comboProductos.setPreferredSize(new Dimension(200, 25));

        JLabel labelCantidad = new JLabel("Cantidad:");
        entryCantidadProducto = new JTextField();
        entryCantidadProducto.setPreferredSize(new Dimension(50, 25));

        JButton btnAgregarProducto = new JButton("Agregar Producto");

        JLabel labelTotalOrdenText = new JLabel("Total Orden:");
        labelTotalOrden = new JLabel("$0.00");

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(labelSeleccionarCliente);
        panelSuperior.add(comboClientes);
        panelSuperior.add(btnCrearOrden);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelCentro.add(labelSeleccionarProducto);
        panelCentro.add(comboProductos);
        panelCentro.add(labelCantidad);
        panelCentro.add(entryCantidadProducto);
        panelCentro.add(btnAgregarProducto);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelInferior.add(labelTotalOrdenText);
        panelInferior.add(labelTotalOrden);

        panel.add(panelSuperior, BorderLayout.NORTH);
        panel.add(panelCentro, BorderLayout.CENTER);
        panel.add(panelInferior, BorderLayout.SOUTH);

        btnCrearOrden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearOrden();
            }
        });

        btnAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProductoAOrden();
            }
        });

        return panel;
    }

    private JPanel crearPanelCalcularTotalCompras() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel labelSeleccionarClienteTotal = new JLabel("Seleccionar Cliente:");
        comboClientesTotal = new JComboBox<>();
        comboClientesTotal.setPreferredSize(new Dimension(200, 25));

        JButton btnCalcularTotal = new JButton("Calcular Total Compras");

        JLabel labelTotalComprasText = new JLabel("Total Compras:");
        labelTotalCompras = new JLabel("$0.00");

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(labelSeleccionarClienteTotal);
        panelSuperior.add(comboClientesTotal);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelInferior.add(btnCalcularTotal);
        panelInferior.add(labelTotalComprasText);
        panelInferior.add(labelTotalCompras);

        panel.add(panelSuperior, BorderLayout.NORTH);
        panel.add(panelInferior, BorderLayout.CENTER);

        btnCalcularTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotalCompras();
            }
        });

        return panel;
    }

    private void inicializarInterfaz() {
        actualizarComboCategorias();
        actualizarComboClientes();
        actualizarComboProductos();
        actualizarComboClientesTotal();
    }

    private void registrarCategoria() {
        String nombreCategoria = entryNombreCategoria.getText();
        if (!nombreCategoria.isEmpty()) {
            Categoria nuevaCategoria = new Categoria(nombreCategoria);
            tienda.registrarCategoria(nuevaCategoria);
            actualizarComboCategorias();
            entryNombreCategoria.setText("");
            JOptionPane.showMessageDialog(this, "Categoría registrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre para la categoría.");
        }
    }

    private void registrarProducto() {
        String nombreProducto = entryNombreProducto.getText();
        double precioProducto;
        try {
            precioProducto = Double.parseDouble(entryPrecioProducto.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un precio válido.");
            return;
        }

        Categoria categoriaSeleccionada = (Categoria) comboCategorias.getSelectedItem();
        if (categoriaSeleccionada != null && !nombreProducto.isEmpty()) {
            Producto nuevoProducto = new Producto(nombreProducto, precioProducto, categoriaSeleccionada);
            tienda.registrarProducto(nuevoProducto);
            actualizarComboProductos();
            entryNombreProducto.setText("");
            entryPrecioProducto.setText("");
            JOptionPane.showMessageDialog(this, "Producto registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        }
    }

    private void registrarCliente() {
        String nombreCliente = entryNombreCliente.getText();
        String apellidoCliente = entryApellidoCliente.getText();
        if (!nombreCliente.isEmpty() && !apellidoCliente.isEmpty()) {
            Cliente nuevoCliente = new Cliente(nombreCliente, apellidoCliente);
            tienda.registrarCliente(nuevoCliente);
            actualizarComboClientes();
            actualizarComboClientesTotal();
            entryNombreCliente.setText("");
            entryApellidoCliente.setText("");
            JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        }
    }

    private void crearOrden() {
        Cliente clienteSeleccionado = (Cliente) comboClientes.getSelectedItem();
        if (clienteSeleccionado != null) {
            ordenActual = new Orden(clienteSeleccionado);
            tienda.registrarOrden(ordenActual);
            labelTotalOrden.setText("$0.00");
            JOptionPane.showMessageDialog(this, "Orden creada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente.");
        }
    }

    private void agregarProductoAOrden() {
        if (ordenActual == null) {
            JOptionPane.showMessageDialog(this, "Por favor, cree una orden primero.");
            return;
        }

        Producto productoSeleccionado = (Producto) comboProductos.getSelectedItem();
        int cantidad;
        try {
            cantidad = Integer.parseInt(entryCantidadProducto.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.");
            return;
        }

        if (productoSeleccionado != null && cantidad > 0) {
            DetalleOrden detalle = new DetalleOrden(productoSeleccionado, cantidad);
            ordenActual.agregarDetalle(detalle);
            double totalOrden = ordenActual.calcularTotal();
            labelTotalOrden.setText(String.format("$%.2f", totalOrden));
            entryCantidadProducto.setText("");
            JOptionPane.showMessageDialog(this, "Producto agregado a la orden exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto y una cantidad válida.");
        }
    }

    private void calcularTotalCompras() {
        Cliente clienteSeleccionado = (Cliente) comboClientesTotal.getSelectedItem();
        if (clienteSeleccionado != null) {
            double totalCompras = tienda.calcularTotalCompras(clienteSeleccionado);
            labelTotalCompras.setText(String.format("$%.2f", totalCompras));
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente.");
        }
    }

    private void actualizarComboCategorias() {
        comboCategorias.removeAllItems();
        for (Categoria categoria : tienda.getCategorias()) {
            comboCategorias.addItem(categoria);
        }
    }

    private void actualizarComboClientes() {
        comboClientes.removeAllItems();
        for (Cliente cliente : tienda.getClientes()) {
            comboClientes.addItem(cliente);
        }
    }

    private void actualizarComboProductos() {
        comboProductos.removeAllItems();
        for (Producto producto : tienda.getProductos()) {
            comboProductos.addItem(producto);
        }
    }

    private void actualizarComboClientesTotal() {
        comboClientesTotal.removeAllItems();
        for (Cliente cliente : tienda.getClientes()) {
            comboClientesTotal.addItem(cliente);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TiendaApp frame = new TiendaApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Clases auxiliares
    class Tienda {
        private ArrayList<Categoria> categorias;
        private ArrayList<Producto> productos;
        private ArrayList<Cliente> clientes;
        private ArrayList<Orden> ordenes;

        public Tienda() {
            categorias = new ArrayList<>();
            productos = new ArrayList<>();
            clientes = new ArrayList<>();
            ordenes = new ArrayList<>();
        }

        public void registrarCategoria(Categoria categoria) {
            categorias.add(categoria);
        }

        public void registrarProducto(Producto producto) {
            productos.add(producto);
        }

        public void registrarCliente(Cliente cliente) {
            clientes.add(cliente);
        }

        public void registrarOrden(Orden orden) {
            ordenes.add(orden);
        }

        public ArrayList<Categoria> getCategorias() {
            return categorias;
        }

        public ArrayList<Producto> getProductos() {
            return productos;
        }

        public ArrayList<Cliente> getClientes() {
            return clientes;
        }

        public ArrayList<Orden> getOrdenes() {
            return ordenes;
        }

        public double calcularTotalCompras(Cliente cliente) {
            double total = 0.0;
            for (Orden orden : ordenes) {
                if (orden.getCliente().equals(cliente)) {
                    total += orden.calcularTotal();
                }
            }
            return total;
        }
    }

    class Categoria {
        private String nombre;

        public Categoria(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    class Producto {
        private String nombre;
        private double precio;
        private Categoria categoria;

        public Producto(String nombre, double precio, Categoria categoria) {
            this.nombre = nombre;
            this.precio = precio;
            this.categoria = categoria;
        }

        public double getPrecio() {
            return precio;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    class Cliente {
        private String nombre;
        private String apellido;

        public Cliente(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public String getNombreCompleto() {
            return nombre + " " + apellido;
        }

        @Override
        public String toString() {
            return getNombreCompleto();
        }
    }

    class Orden {
        private Cliente cliente;
        private ArrayList<DetalleOrden> detalles;

        public Orden(Cliente cliente) {
            this.cliente = cliente;
            detalles = new ArrayList<>();
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void agregarDetalle(DetalleOrden detalle) {
            detalles.add(detalle);
        }

        public double calcularTotal() {
            double total = 0.0;
            for (DetalleOrden detalle : detalles) {
                total += detalle.calcularSubtotal();
            }
            return total;
        }
    }

    class DetalleOrden {
        private Producto producto;
        private int cantidad;

        public DetalleOrden(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

        public double calcularSubtotal() {
            return producto.getPrecio() * cantidad;
        }
    }
}
