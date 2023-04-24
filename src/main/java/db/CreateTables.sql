USE mineral;
CREATE TABLE IF NOT EXISTS `heterogeneousMineral`
(
    `id`                                 INT auto_increment,
    `mineralName`                        varchar(255) NOT NULL,
    `reflectanceVisualInspectionLevel`   varchar(255),
    `visualClassificationOfReflectivity` varchar(255),
    `doubleReflection`                   varchar(255),
    `internalReflection`                 varchar(255),
    `markHardness`                       varchar(255),
    `mohsHardness`                       varchar(255),
    `vickersHardness`                    varchar(255),
    `Rotation`                           varchar(255),
    `_Match`                             varchar(255),
    `lightSymbol`                        varchar(255),
    `non_HomogeneousViewRotationAngle`   varchar(255),
    `Dispersion`                         varchar(255),
    `non_HomogeneousVisualRotationColor` varchar(255),
    `rotationalDispersion`               varchar(255),
    PRIMARY KEY (`id`),
    UNIQUE (`mineralName`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `homogeneousMineral`
(
    `id`                                 INT auto_increment,
    `mineralName`                        varchar(255) NOT NULL,
    `reflectanceVisualInspectionLevel`   varchar(255),
    `visualClassificationOfReflectivity` varchar(255),
    `internalReflection`                 varchar(255),
    `markHardness`                       varchar(255),
    `mohsHardness`                       varchar(255),
    `vickersHardness`                    varchar(255),
    `reflectionRotationAngle`            varchar(255),
    PRIMARY KEY (`id`),
    UNIQUE (`mineralName`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;