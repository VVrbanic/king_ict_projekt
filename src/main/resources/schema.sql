CREATE TABLE meta (
      meta_id INT PRIMARY KEY AUTO_INCREMENT,
      created_at VARCHAR(255) NOT NULL,
      updated_at VARCHAR(255) NOT NULL,
      barcode VARCHAR(255),
      qr_code VARCHAR(255)
);

CREATE TABLE dimensions (
        dimension_id INT PRIMARY KEY AUTO_INCREMENT,
        width DOUBLE NOT NULL,
        height DOUBLE NOT NULL,
        depth DOUBLE NOT NULL
);

CREATE TABLE reviews (
     review_id INT PRIMARY KEY AUTO_INCREMENT,
     product_id INT,
     rating INT NOT NULL,
     comment TEXT,
     date VARCHAR(255),
     reviewer_name VARCHAR(255),
     reviewer_email VARCHAR(255),
     FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE product(
    id INT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    category VARCHAR(255),
    price FLOAT,
    discount_percentage FLOAT,
    rating FLOAT,
    stock INT,
    brand VARCHAR(255),
    sku VARCHAR(255),
    weight INT,
    warranty_information VARCHAR(255),
    shipping_information VARCHAR(255),
    availability_status VARCHAR(255),
    return_policy VARCHAR(255),
    minimum_order_quantity INT,
    thumbnail VARCHAR(255),
    meta_id INT, FOREIGN KEY (meta_id) REFERENCES meta(meta_id),
    dimension_id INT FOREIGN KEY (dimension_id) REFERENCES dimensions(dimension_id),
    tag_id INT FOREIGN KEY (tag_id) REFERENCES tags(tag_id),
    images TEXT,
    reviews TEXT
);
