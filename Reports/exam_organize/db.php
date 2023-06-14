<?php

class DatabaseConnection {
    private $host;
    private $username;
    private $password;
    private $database;
    private $conn;
    public static $instance = null;

    // public function __construct($host, $username, $password, $database) {
    //     $this->host = $host;
    //     $this->username = $username;
    //     $this->password = $password;
    //     $this->database = $database;
        
    //     $this->conn = new mysqli($this->host, $this->username, $this->password, $this->database);
    //     if ($this->conn->connect_error) {
    //         die("Connection failed: " . $this->conn->connect_error);
    //     }
    // }
        
    public static function getInstance(){
        if(!self::$instance){
            self::$instance = new mysqli("localhost","root","","organize_exam");
            if (self::$instance->connect_error) {
                die("Connection failed: " . $this->conn->connect_error);
            }
        }
        return self::$instance;
    }

    public function closeConnection() {
        $this->conn->close();
    }


}




