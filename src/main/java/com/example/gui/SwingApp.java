package com.example.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.basesdedatos.model.ContratoAlquiler;
import com.basesdedatos.model.Inquilino;
import com.basesdedatos.model.Propiedad;
import com.basesdedatos.model.Propietario;
import com.basesdedatos.repository.ConsultaContratosAlquiler;

public class SwingApp extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private ConsultaContratosAlquiler consulta;

    public SwingApp() {
        consulta = new ConsultaContratosAlquiler();

        setTitle("Consulta de Contratos de Alquiler e Inquilinos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

    
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton contratosButton = new JButton("Mostrar Contratos");
        contratosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarContratos();
            }
        });
        buttonPanel.add(contratosButton);

        JButton inquilinosButton = new JButton("Mostrar Inquilinos > 30");
        inquilinosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInquilinosMayoresDe30();
            }
        });
        buttonPanel.add(inquilinosButton);


        JButton propiedadesBarrioButton = new JButton("Mostrar Propiedades en Barrio");
        propiedadesBarrioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPropiedadesEnBarrio();
            }
        });

        buttonPanel.add(propiedadesBarrioButton);

      
        JButton contarPropiedadesButton = new JButton("Contar Propiedades por Propietario");
        contarPropiedadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contarPropiedadesPorPropietario();
            }
        });
        buttonPanel.add(contarPropiedadesButton);


        JButton propietariosContactoButton = new JButton("Mostrar Propietarios con Contacto y Propiedades");
        propietariosContactoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPropietariosConContactoYPropiedades();
            }
        });
        buttonPanel.add(propietariosContactoButton);


        JButton propiedadesMasTresHabitacionesButton = new JButton("Propiedades con más de 3 Habitaciones");
        propiedadesMasTresHabitacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPropiedadesConMasDeTresHabitaciones();
            }
        });
        buttonPanel.add(propiedadesMasTresHabitacionesButton);

        JButton inquilinosConMascotasButton = new JButton("Inquilinos con Mascotas");
        inquilinosConMascotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInquilinosConMascotas();
            }
        });
        buttonPanel.add(inquilinosConMascotasButton);


        JButton propiedadesButton = new JButton("Mostrar Propiedades");
        propiedadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPropiedadesPorPisosYArea();
            }
        });
        buttonPanel.add(propiedadesButton);


   



        

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void mostrarContratos() {
        List<ContratoAlquiler> contratos = consulta.listarContratosAlquiler();

  
        tableModel.setColumnCount(0);
        tableModel.addColumn("ID Contrato");
        tableModel.addColumn("Precio Alquiler");
        tableModel.addColumn("Forma Pago");

    
        tableModel.setRowCount(0);


        for (ContratoAlquiler contrato : contratos) {
            tableModel.addRow(new Object[]{
                contrato.getIdContrato(),
                contrato.getPrecioAlquiler(),
                contrato.getFormaPago()
            });
        }
    }

    private void mostrarInquilinosMayoresDe30() {
        List<Inquilino> inquilinos = consulta.listarInquilinosMayoresDe30();

        tableModel.setColumnCount(0);
        tableModel.addColumn("ID Inquilino");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Edad");
        tableModel.addColumn("Ocupación");
        tableModel.addColumn("Salario");
        tableModel.addColumn("Número de Mascotas");
        tableModel.addColumn("Contactos");


        tableModel.setRowCount(0);

       
        for (Inquilino inquilino : inquilinos) {
            tableModel.addRow(new Object[]{
                inquilino.getIdInquilino(),
                inquilino.getNombre(),
                inquilino.getEdad(),
                inquilino.getOcupacion(),
                inquilino.getSalario(),
                inquilino.getNumMascotas(),
                inquilino.getContactos()
            });
        }
    }


    private void mostrarPropiedadesEnBarrio() {
        String barrio = JOptionPane.showInputDialog("Ingrese el nombre del barrio:");
        if (barrio != null && !barrio.isEmpty()) {
            List<Propiedad> propiedades = consulta.listarPropiedadesEnBarrio(barrio);

            
            tableModel.setColumnCount(0);
            tableModel.addColumn("ID Propiedad");
            tableModel.addColumn("Estrato");
            tableModel.addColumn("Barrio");
            tableModel.addColumn("Num Habitaciones");
            tableModel.addColumn("Num Pisos");
            tableModel.addColumn("Área");
            tableModel.addColumn("Antigüedad");
            tableModel.addColumn("Num Parqueaderos");
            tableModel.addColumn("Num Inquilinos");
            tableModel.addColumn("Propiedades Col");

            
            tableModel.setRowCount(0);

            for (Propiedad propiedad : propiedades) {
                tableModel.addRow(new Object[]{
                        propiedad.getIdPropiedad(),
                        propiedad.getNumEstrato(),
                        propiedad.getBarrio(),
                        propiedad.getNumHabitaciones(),
                        propiedad.getNumPisos(),
                        propiedad.getAreaDePropiedad(),
                        propiedad.getAntiguedadInmueble(),
                        propiedad.getNumParqueaderos(),
                        propiedad.getInquilinos(),
                        propiedad.getPropiedadescol()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de barrio válido.");
        }
    }



    private void contarPropiedadesPorPropietario() {
        List<Propietario> propietarios = consulta.contarPropiedadesPorPropietario();

       
        tableModel.setColumnCount(0);
        tableModel.addColumn("ID Propietario");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Num Propiedades");

        
        tableModel.setRowCount(0);

    
        for (Propietario propietario : propietarios) {
            tableModel.addRow(new Object[]{
                    propietario.getIdPropietario(),
                    propietario.getNombre(),
                    propietario.getNumPropiedades()
            });
        }
    }


    private void mostrarPropietariosConContactoYPropiedades() {
        List<Propietario> propietarios = consulta.listarPropietariosConContactoYPropiedades();

        // Configurar columnas del modelo de tabla para propietarios
        tableModel.setColumnCount(0);
        tableModel.addColumn("ID Propietario");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Num Propiedades");
        tableModel.addColumn("Contacto");

        // Limpiar el modelo de la tabla
        tableModel.setRowCount(0);

        // Añadir los datos a la tabla
        for (Propietario propietario : propietarios) {
            tableModel.addRow(new Object[]{
                    propietario.getIdPropietario(),
                    propietario.getNombre(),
                    propietario.getNumPropiedades(),
                    propietario.getContacto()
            });
        }
    }



    private void mostrarPropiedadesConMasDeTresHabitaciones() {
        List<Propiedad> propiedades = consulta.listarPropiedadesConMasDeTresHabitaciones();

        // Configurar columnas del modelo de tabla para propiedades
        tableModel.setColumnCount(0);
        tableModel.addColumn("ID Propiedad");
        tableModel.addColumn("Barrio");
        tableModel.addColumn("Habitaciones");


        // Limpiar el modelo de la tabla
        tableModel.setRowCount(0);

        // Añadir los datos a la tabla
        for (Propiedad propiedad : propiedades) {
            tableModel.addRow(new Object[]{
                    propiedad.getIdPropiedad(),
                    propiedad.getBarrio(),
                    propiedad.getNumHabitaciones(),

            });
        }
    }

    private void mostrarInquilinosConMascotas() {
        List<Inquilino> inquilinos = consulta.listarInquilinosConMascotas();

        // Configurar columnas del modelo de tabla para inquilinos
        tableModel.setColumnCount(0);
        tableModel.addColumn("ID Inquilino");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Edad");
        tableModel.addColumn("Ocupacion");
        tableModel.addColumn("Salario");
        tableModel.addColumn("Num Mascotas");
        tableModel.addColumn("Contactos");

        // Limpiar el modelo de la tabla
        tableModel.setRowCount(0);

        // Añadir los datos a la tabla
        for (Inquilino inquilino : inquilinos) {
            tableModel.addRow(new Object[]{
                    inquilino.getIdInquilino(),
                    inquilino.getNombre(),
                    inquilino.getEdad(),
                    inquilino.getOcupacion(),
                    inquilino.getSalario(),
                    inquilino.getNumMascotas(),
                    inquilino.getContactos()
            });
        }
    }


    private void mostrarPropiedadesPorPisosYArea() {
        List<Propiedad> propiedades = consulta.listarPropiedadesPorPisosYArea();

        tableModel.setColumnCount(0);
        tableModel.addColumn("ID Propiedad");
        tableModel.addColumn("Num Pisos");
        tableModel.addColumn("Área");

        tableModel.setRowCount(0);

        for (Propiedad propiedad : propiedades) {
            tableModel.addRow(new Object[]{
                    propiedad.getIdPropiedad(),
                    propiedad.getNumPisos(),
                    propiedad.getAreaDePropiedad()
            });
        }
    }





   




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingApp().setVisible(true);
            }
        });
    }
}
