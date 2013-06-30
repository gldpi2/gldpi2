/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UserDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author artur
 */
public class UserTableModel extends AbstractTableModel {

    private List<User> linhas;
    UserDAO dao = new UserDAO();

    public UserTableModel() {
        linhas = new ArrayList<>();
    }

    public UserTableModel(List<User> usersList) {
        linhas = new ArrayList<>(usersList);
    }
    private String[] colunas = new String[]{"Nome", "Email", "Matrícula", "Perfil", "Ativo"};
    private static final int NAME = 0;
    private static final int EMAIL = 1;
    private static final int REGISTER = 2;
    private static final int PROFILE = 3;
    private static final int ENABLE = 4;

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        User user = linhas.get(rowIndex);

        switch (columnIndex) {
            case NAME:
                return user.getName();
            case REGISTER:
                return user.getRegister();
            case EMAIL:
                return user.getEmail();
            case PROFILE:
                if (user.getProfile().equals(1)) {
                    return "Administrador";
                }
                if (user.getProfile().equals(2)) {
                    return "Técnico";
                }
           case ENABLE:
                if (user.getEnable().equals(1)) {
                    return "Ativo";
                }
                if (user.getEnable().equals(0)) {
                    return "Inativo";
                }
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds!");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        User user = linhas.get(rowIndex);

        switch (columnIndex) {
            case NAME:
                user.setName((String) aValue);
                break;
            case REGISTER:
                user.setRegister((String) aValue);
                break;
            case EMAIL:
                user.setEmail((String) aValue);
                break;
            case PROFILE:
                if (aValue.equals("Administrador")) {
                    user.setProfile(1);
                    break;
                }
                if (aValue.equals("Técnico")) {
                    user.setProfile(2);
                    break;
                }
            case ENABLE:
                if (aValue.equals("Ativo")) {
                    user.setEnable(1);
                    break;
                }
                if (aValue.equals("Inativo")) {
                    user.setEnable(0);
                    break;
                }
                throw new IllegalArgumentException("Perfil de usuário desconhecido!");
        }
        try {
            dao.updateUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public boolean cellSelectionEnabled(int rowIndex, int columnIndex) {
        return false;
    }
    
    public boolean rowSelectionAllowed() {
        return true;
    }

    public User getUser(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addUser(User user) throws SQLException {
        // Adiciona o registro.
        linhas.add(user);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        dao.createUser(user);
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeUser(int indiceLinha) throws SQLException {
        // Remove o registro.
        User user = linhas.get(indiceLinha);
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        dao.deleteUser(user);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addUserList(List<User> users) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(users);

        // Notifica a mudança.
        dao.createUsers(users);
        fireTableRowsInserted(indice, indice + users.size());
    }

// Remove todos os registros.
    public void limpar() {
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}
