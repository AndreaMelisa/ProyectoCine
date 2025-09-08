import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClientModule, HttpClient } from '@angular/common/http';

interface Pelicula {
  id: number;
  titulo: string;
  genero: string;
  duracion: number;
  imagen: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone: true,
  imports: [CommonModule, RouterModule, HttpClientModule]
})
export class HomeComponent implements OnInit {
  sliders: string[] = ['slider_1.webp', 'slider_2.webp', 'slider_3.webp', 'slider_4.webp'];
  peliculas: Pelicula[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Pelicula[]>('http://localhost:9000/api/peliculas')
      .subscribe({
        next: data => this.peliculas = data,
        error: err => console.error('Error al cargar películas', err)
      });
  }
}
