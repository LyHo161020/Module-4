package com.cg.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CityDTO {
    private Long id;


    @NotBlank(message = "Tên thành phố không được để trống!")
    @Size(min = 5, max = 50, message = "Tên phải gồm từ 5-50 kí tự!")
    private String cityName;

    @NotBlank(message = "Tên thành phố không được để trống!")
    private String nation;

    @NotBlank(message = "Tên thành phố không được để trống!")
    private String area;

    @NotBlank(message = "Tên thành phố không được để trống!")
    private String population;

    @NotBlank(message = "Tên thành phố không được để trống!")
    private String gdp;

    @Size(max = 255, message = "Mô tả quá dài vượt quá 255 kí tự")
    private String description;


    public City toCity(Nation nation) {
        return new City()
                .setCityName(cityName)
                .setNation(nation)
                .setArea(Double.parseDouble(area))
                .setGdp(Integer.parseInt(gdp))
                .setPopulation(Integer.parseInt(population))
                .setDescription(description);
    }
}
