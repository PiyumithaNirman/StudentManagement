package com.example.StudentManagement.dto.Paginated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseDTO<T> {
    private List<T> list;
    private long datFullCount;

}