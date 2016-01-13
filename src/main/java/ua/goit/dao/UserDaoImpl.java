package ua.goit.dao;

import ua.goit.factory.ConnectionGetAndFree;
import ua.goit.factory.ConnectionPoolNames;
import ua.goit.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
  private final ConnectionGetAndFree connectionGetAndFree;

  public UserDaoImpl(ConnectionGetAndFree connectionGetAndFree) {
    this.connectionGetAndFree = connectionGetAndFree;
  }

  @Override
  public void add(User entity) {
    PreparedStatement statement = null;
    String sql = "INSERT INTO Users (name, login, password, token, email, activationKey) VALUES (?,?,?,?,?,?)";
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.prepareStatement(sql);
      statement.setString(1, entity.getName());
      statement.setString(2, entity.getLogin());
      statement.setString(3, entity.getPassword());
      statement.setString(4, "0");
      statement.setString(5, entity.getEmail());
      statement.setString(6, entity.getActivationKey());
      statement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }
  }

  @Override
  public User getById(Integer id) {
    Statement statement = null;
    User user = null;
    String sql = "SELECT id, name, login, password, token, timestamp, email, activationKey, activeFlag FROM Users WHERE id = " + id;
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        user = getUser(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }

    return user;
  }

  @Override
  public List<User> getAll() {
    Statement statement = null;
    User user = null;
    List<User> listWithUser = new ArrayList<User>();
    String sql = "SELECT id, name, login, password, token, timestamp, email, activationKey, activeFlag FROM Users";
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        user = getUser(rs);
        listWithUser.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }

    return listWithUser;
  }

  @Override
  public void update(User entity) {
    PreparedStatement statement = null;
    String sql = "UPDATE Users SET name = ?, password = ?, token = ?, activeFlag = ? WHERE id = ?";
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.prepareStatement(sql);
      statement.setString(1, entity.getName());
      statement.setString(2, entity.getPassword());
      statement.setString(3, entity.getToken());
      statement.setInt(4, entity.isActive());
      statement.setInt(5, entity.getId());
      statement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }
  }

  @Override
  public void remove(Integer id) {
    PreparedStatement statement = null;
    String sql = "DELETE FROM Users WHERE id = ?";
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      statement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }
  }

  @Override
  public User getByLogin(String login) {
    Statement statement = null;
    User user = null;
    String sql = "SELECT id, name, login, password, token, timestamp, email, activationKey, activeFlag FROM Users WHERE login =" + "'" + login + "'";
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        user = getUser(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }

    return user;
  }

  private User getUser(ResultSet rs) throws SQLException {
    Integer id = rs.getInt("id");
    String name = rs.getString("name");
    String login = rs.getString("login");
    String password = rs.getString("password");
    String token = rs.getString("token");
    Timestamp timestamp = rs.getTimestamp("timeStamp");
    String email = rs.getString("email");
    String activationKey = rs.getString("activationKey");
    Integer activeFlag = rs.getInt("activeFlag");
    return new User(id, name, login, password, token, timestamp, email, activationKey, activeFlag);
  }

  private Timestamp getCurrentTimeStamp() {
    java.util.Date today = new java.util.Date();
    return new Timestamp(today.getTime());
  }

  @Override
  public User findByToken(String token) {
    PreparedStatement statement = null;
    String sql = "SELECT * FROM USERS WHERE token = ?";
    Connection connection = null;
    User user = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.prepareStatement(sql);
      statement.setString(1, token);
      ResultSet rs = statement.executeQuery();
      rs.next();
      String username = rs.getString("name");
      int id = rs.getInt("id");
      user = new User(id, username, null, null, null, null);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }
    return user;
  }

  @Override
  public User findByActivationKey(String key) {
    Statement statement = null;
    User user = null;
    String sql = "SELECT id, name, login, password, token, timestamp, email, activationKey, activeFlag FROM Users WHERE activationKey =" + "'" + key + "'";
    Connection connection = null;
    try {
      connection = connectionGetAndFree.getConnection();
      statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        user = getUser(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connectionGetAndFree.freeConnection(connection);
    }
    return user;
  }
}
