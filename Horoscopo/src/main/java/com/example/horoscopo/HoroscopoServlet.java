package com.example.horoscopo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "HoroscopoServlet", value = "/horoscopo-servlet")
public class HoroscopoServlet extends HttpServlet {
    private Map<String, String> horoscopoData;

    public void init() throws ServletException {
        horoscopoData = new HashMap<>();
        try {
            String filePath = getServletContext().getRealPath("/") + "/horoscopo.txt";
            System.out.println("Carregando arquivo de horóscopo do caminho: " + filePath);

            BufferedReader leitor = new BufferedReader(new FileReader(filePath));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split("#");
                if (partes.length == 3) {
                    horoscopoData.put(partes[0].trim(), partes[1] + "#" + partes[2]);
                    System.out.println("Signo carregado: " + partes[0]);
                } else {
                    System.out.println("Linha mal formatada: " + linha);
                }
            }
            leitor.close();
        } catch (IOException e) {
            throw new ServletException("Erro ao carregar o arquivo texto", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String birthdate = request.getParameter("birthdate");

        String signo = identificarSigno(birthdate);
        System.out.println("Signo identificado: " + signo);

        String infoHoroscopo = horoscopoData.get(signo);
        if (infoHoroscopo != null) {
            String[] partes = infoHoroscopo.split("#");
            request.setAttribute("signo", signo);
            request.setAttribute("image", partes[0]);
            request.setAttribute("horoscopo", partes[1]);

            System.out.println("Signo: " + signo);
            System.out.println("Imagem: " + partes[0]);
            System.out.println("Horóscopo: " + partes[1]);


        } else {
            request.setAttribute("error", "Não foi possível encontrar informações para o signo " + signo);
            System.out.println("Erro: Não foi possível encontrar informações para o signo " + signo);
        }

        request.getRequestDispatcher("/horoscopo.jsp").forward(request, response);
    }

    private String identificarSigno(String aniversario) {
        String[] partes = aniversario.split("-");
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);

        if ((dia >= 21 && mes == 3) || (dia <= 20 && mes == 4)) {
            return "Aries";
        } else if ((dia >= 21 && mes == 4) || (dia <= 20 && mes == 5)) {
            return "Touro";
        } else if ((dia >= 21 && mes == 5) || (dia <= 20 && mes == 6)) {
            return "Gemeos";
        } else if ((dia >= 21 && mes == 6) || (dia <= 22 && mes == 7)) {
            return "Cancer";
        } else if ((dia >= 23 && mes == 7) || (dia <= 22 && mes == 8)) {
            return "Leao";
        } else if ((dia >= 23 && mes == 8) || (dia <= 22 && mes == 9)) {
            return "Virgem";
        } else if ((dia >= 23 && mes == 9) || (dia <= 22 && mes == 10)) {
            return "Libra";
        } else if ((dia >= 23 && mes == 10) || (dia <= 21 && mes == 11)) {
            return "Escorpiao";
        } else if ((dia >= 22 && mes == 11) || (dia <= 21 && mes == 12)) {
            return "Sagitario";
        } else if ((dia >= 22 && mes == 12) || (dia <= 20 && mes == 1)) {
            return "Capricornio";
        } else if ((dia >= 21 && mes == 1) || (dia <= 18 && mes == 2)) {
            return "Aquario";
        } else if ((dia >= 19 && mes == 2) || (dia <= 20 && mes == 3)) {
            return "Peixes";
        } else {
            return "Data invalida";
        }
    }


}
